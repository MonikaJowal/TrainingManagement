package com.hcl.dashboardcreation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.dashboardcreation.domain.Dashboard;
@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
	public List<Dashboard> findAll();
	public Dashboard findById(long id);

}
