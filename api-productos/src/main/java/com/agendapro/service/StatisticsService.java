package com.agendapro.service;

import com.agendapro.domain.Statistics;

public interface StatisticsService {

    void updateStatistics(String category);
    Statistics getStatisticsByCategory(String category);
}
