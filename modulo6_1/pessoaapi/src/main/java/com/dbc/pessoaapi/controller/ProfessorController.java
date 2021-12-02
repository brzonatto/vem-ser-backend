package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professor")
@Validated
@RequiredArgsConstructor
@Slf4j
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorEntity create(@RequestBody @Valid ProfessorEntity professorEntity) {
       return professorRepository.save(professorEntity);
    }

    @GetMapping
    public List<ProfessorEntity> list() {
        return professorRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }
}
