package com.agendapro.service.impl;

import com.agendapro.domain.Statistics;
import com.agendapro.repository.StatisticsRepository;
import com.agendapro.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Async
    public void updateStatistics(String category) {
        Statistics stats = statisticsRepository.findByCategory(category);
        if (stats == null) {
            stats = new Statistics();
            stats.setCategory(category);
            stats.setCount(1L);
        } else {
            stats.setCount(stats.getCount() + 1);
        }
        statisticsRepository.save(stats);
    }

    public Statistics getStatisticsByCategory(String category) {
        return statisticsRepository.findByCategory(category);
    }
}
