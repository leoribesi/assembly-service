-- Migration: Create initial tables for Assembly Service
-- Description: Creates all entity tables for the Assembly Service Application

-- ============================================
-- Table: agenda
-- ============================================
CREATE TABLE agenda (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- Table: associate
-- ============================================
CREATE TABLE associate (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ============================================
-- Table: session
-- ============================================
CREATE TABLE session (
    id BIGSERIAL PRIMARY KEY,
    agenda_id BIGINT NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_session_agenda FOREIGN KEY (agenda_id) REFERENCES agenda(id)
);

-- ============================================
-- Table: vote
-- ============================================
CREATE TABLE vote (
    id BIGSERIAL PRIMARY KEY,
    vote VARCHAR(3) NOT NULL,
    session_id BIGINT NOT NULL,
    associate_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_vote_session FOREIGN KEY (session_id) REFERENCES session(id),
    CONSTRAINT fk_vote_associate FOREIGN KEY (associate_id) REFERENCES associate(id),
    CONSTRAINT chk_vote_type CHECK (vote IN ('YES', 'NO'))
);

-- ============================================
-- Indexes
-- ============================================
CREATE INDEX idx_session_agenda ON session(agenda_id);
CREATE INDEX idx_vote_session ON vote(session_id);
CREATE INDEX idx_vote_associate ON vote(associate_id);
CREATE UNIQUE INDEX idx_vote_unique ON vote(session_id, associate_id);