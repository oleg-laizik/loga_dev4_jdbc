WITH project_duration_in_month AS (SELECT ID, (TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE)) AS MONTH_COUNT
                   FROM project),
     project_price AS (SELECT project.ID,
                              client.NAME,
                              SUM(worker.SALARY * project_duration_in_month.MONTH_COUNT)
                      AS PRICE
                   FROM project
      JOIN client ON project.CLIENT_ID = client.ID
      JOIN project_duration_in_month ON project.ID = project_duration_in_month.ID
      JOIN project_worker ON project.ID = project_worker.PROJECT_ID
      JOIN worker ON project_worker.WORKER_ID = worker.ID
                   GROUP BY project.ID)
SELECT NAME, PRICE
FROM project_price
ORDER BY PRICE DESC;