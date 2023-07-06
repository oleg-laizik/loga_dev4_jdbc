package loga.dev4.jdbc;

import loga.dev4.jdbc.services.DatabaseQueryService;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;

@Slf4j
public class LauncherMain {
    @SneakyThrows
    public static void main(String[] args) {


        log.info(new DatabaseQueryService().findLongestProject().toString());
        log.info(new DatabaseQueryService().findMaxProjectsCountClient().toString());
        log.info(new DatabaseQueryService().findMaxSalary().toString());
        log.info(new DatabaseQueryService().findProjectPrices().toString());
        log.info(new DatabaseQueryService().findYoungestEldestWorkers().toString());
        }
    }
