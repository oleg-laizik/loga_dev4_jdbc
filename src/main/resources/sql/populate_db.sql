INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
  ('John Doe', '1990-01-01', 'Trainee', 800),
  ('Jane Smith', '1985-02-15', 'Junior', 1200),
  ('Mark Johnson', '1980-06-30', 'Middle', 2500),
  ('Sarah Williams', '1975-09-10', 'Middle', 2800),
  ('Michael Brown', '1972-12-20', 'Senior', 4000),
  ('Emily Davis', '1992-03-05', 'Trainee', 900),
  ('Daniel Anderson', '1988-07-12', 'Junior', 1500),
  ('Olivia Taylor', '1983-11-25', 'Middle', 2700),
  ('James Wilson', '1978-04-15', 'Middle', 3000),
  ('Sophia Martinez', '1970-10-08', 'Senior', 4500);


INSERT INTO client (NAME) VALUES
  ('Client A'),
  ('Client B'),
  ('Client C'),
  ('Client D'),
  ('Client E');


INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
  (1, '2023-01-01', '2023-06-30'),
  (2, '2023-02-15', '2023-09-30'),
  (3, '2023-03-01', '2023-12-31'),
  (4, '2023-04-10', '2024-03-31'),
  (5, '2023-05-01', '2024-06-30'),
  (3, '2023-06-15', '2024-02-28'),
  (2, '2023-07-01', '2024-01-31'),
  (1, '2023-08-10', '2024-05-31'),
  (4, '2023-09-01', '2024-03-31'),
  (5, '2023-10-15', '2024-06-30');


INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 4),
  (2, 5),
  (3, 6),
  (4, 7),
  (5, 8),
  (6, 9),
  (7, 10),
  (7, 1),
  (8, 2),
  (8, 3),
  (8, 4),
  (9, 5),
  (10, 6),
  (10, 7),
  (10, 8),
  (10, 9),
  (10, 10);