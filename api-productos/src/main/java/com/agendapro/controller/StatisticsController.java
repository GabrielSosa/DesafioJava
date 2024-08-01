package com.agendapro.controller;

import com.agendapro.domain.Statistics;
import com.agendapro.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping("/{category}")
    public ResponseEntity<Statistics> getStatisticsByCategory(@PathVariable String category) {
        Statistics statistics = statisticsService.getStatisticsByCategory(category);
        return ResponseEntity.ok(statistics);
    }
}