package pe.edu.vallegrande.teacher.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.teacher.application.service.ITeacherService;
import pe.edu.vallegrande.teacher.domain.dto.TeacherRequest;
import pe.edu.vallegrande.teacher.domain.dto.TeacherResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/public/teachers${api.version}")
@RequiredArgsConstructor
public class TeacherPublicController {

    private final ITeacherService teacherService;

    @GetMapping("/all")
    public Flux<TeacherResponse> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/active")
    public Flux<TeacherResponse> getActive() {
        return teacherService.getActive();
    }

    @GetMapping("/inactive")
    public Flux<TeacherResponse> getInactive() {
        return teacherService.getInactive();
    }

    @GetMapping("/{id}")
    public Mono<TeacherResponse> getById(@PathVariable String id) {
        return teacherService.getById(id);
    }

    @GetMapping("/uid/{uid}")
    public Mono<ResponseEntity<String>> getTeacherIdByUid(@PathVariable String uid) {
        return teacherService.getTeacherIdByUid(uid)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }


    @GetMapping("/document/{documentNumber}")
    public Mono<TeacherResponse> getByDocumentNumber(@PathVariable String documentNumber) {
        return teacherService.getByDocumentNumber(documentNumber);
    }

    @PostMapping("/create")
    public Mono<TeacherResponse> create(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.create(teacherRequest);
    }

    @PutMapping("/update/{id}")
    public Mono<TeacherResponse> update(@PathVariable String id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.update(id, teacherRequest);
    }

    @PatchMapping("/password/{id}")
    public Mono<Void> modifyPassword(@PathVariable String id, @RequestBody String password) {
        return teacherService.modifyPassword(id, password);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> modifyStatus(@PathVariable String id, @RequestBody String status) {
        return teacherService.modifyStatus(id, status);
    }

}
