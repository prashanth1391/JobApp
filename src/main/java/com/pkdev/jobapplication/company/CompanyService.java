package com.pkdev.jobapplication.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    boolean updateCompanyById(Long id, Company company);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
}
