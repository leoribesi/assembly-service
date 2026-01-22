-- Migration: Insert initial data for Assembly Service
-- Description: Populates initial data for testing and development

-- ============================================
-- Insert into agenda
-- ============================================
INSERT INTO agenda (title, description, created_at, updated_at)
VALUES ('Todas as pessoas tem o direito de respirar?', 'Discussão e votação sobre propostas da assembléia geral', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ============================================
-- Insert into associate
-- ============================================
INSERT INTO associate (name, cpf, created_at, updated_at)
VALUES
    ('João Silva', '01524616044', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Maria Santos', '80125652003', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Pedro Oliveira', '90567889068', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ============================================
-- Insert into session
-- ============================================
INSERT INTO session (agenda_id, start_time, end_time, created_at, updated_at)
VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP + INTERVAL '1 hour', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ============================================
-- Insert into vote
-- ============================================
INSERT INTO vote (vote, session_id, associate_id, created_at, updated_at)
VALUES
    ('YES', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('YES', 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('NO', 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);