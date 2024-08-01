package com.agendapro.repository;
import com.agendapro.domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Statistics findByCategory(String category);
}