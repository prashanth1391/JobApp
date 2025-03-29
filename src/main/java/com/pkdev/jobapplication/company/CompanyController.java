package com.pkdev.jobapplication.company;

import com.pkdev.jobapplication.job.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyId(@PathVariable Long id, @RequestBody Company company){
        boolean updated = companyService.updateCompanyById(id,company);
        if(updated)
            return ResponseEntity.ok("Company updated successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company successfully created",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean deleted = companyService.deleteCompanyById(id);
        if(deleted){
            return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}

