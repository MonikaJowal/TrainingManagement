package in.hcl.schedule_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.hcl.schedule_management.domain.Schedule;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
