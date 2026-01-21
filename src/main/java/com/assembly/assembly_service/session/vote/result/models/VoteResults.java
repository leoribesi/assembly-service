package com.assembly.assembly_service.session.vote.result.models;

public record VoteResults(
        String agenda,
        Integer yes,
        Integer no
) {
}
