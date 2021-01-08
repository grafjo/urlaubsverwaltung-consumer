package de.bitbordell.labs.urlaubsverwaltung.consumer;

import de.bitbordell.labs.urlaubsverwaltung.client.api.DepartmentApiControllerApi;
import de.bitbordell.labs.urlaubsverwaltung.client.model.DepartmentsDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
public class DepartmentController {

    private final DepartmentApiControllerApi departmentApiControllerApi;

    public DepartmentController(DepartmentApiControllerApi departmentApiControllerApi) {
        this.departmentApiControllerApi = departmentApiControllerApi;
    }

    @GetMapping("/department")
    String getIdentityProviders(Model model) {

        Mono<DepartmentsDto> departments = departmentApiControllerApi.departmentsUsingGET();

        model.addAttribute("departments", departments.block().getDepartments());
        return "department/list.html";
    }

}
