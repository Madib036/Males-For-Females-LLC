DECLARE JOB_START_TIMESTAMP TIMESTAMP;

-- Create table books.
CREATE OR REPLACE TABLE books AS
SELECT 'Hamlet' title, 'William Shakespeare' author;

-- Insert two rows into the books.
INSERT books (title, author)
VALUES('The Great Gatsby', 'F. Scott Fizgerald'),
      ('War and Peace', 'Leo Tolstoy');

SELECT * FROM books;

SET JOB_START_TIMESTAMP = (
  SELECT start_time
  FROM `region-us`.INFORMATION_SCHEMA.JOBS_BY_USER
  WHERE job_type="QUERY"
    AND statement_type="INSERT"
  ORDER BY start_time DESC
  LIMIT 1
 );

-- This query only returns Hamlet, William Shakespeare as result.
SELECT * FROM books FOR SYSTEM_TIME AS OF JOB_START_TIMESTAMP;