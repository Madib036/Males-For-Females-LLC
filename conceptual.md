-- Before PIVOT is used to rotate sales and quarter into Q1, Q2, Q3, Q4 columns:
/*---------+-------+---------+------+
 | product | sales | quarter | year |
 +---------+-------+---------+------|
 | Madi    | 51    | Q1      | 2025 |
 | Madi    | 23    | Q2      | 2025 |
 | Nadi    | 45    | Q3      | 2025 |
 | Madi    | 3     | Q4      | 2025 |
 | Madi    | 70    | Q1      | 2025 |
 | Madi    | 85    | Q2      | 2025 |
 | Apple   | 77    | Q1      | 2025 |
 | Apple   | 4     | Q2      | 2025 |
 | Apple   | 1     | Q1      | 2025 |
 +---------+-------+---------+------*/

-- After PIVOT is used to rotate sales and quarter into Q1, Q2, Q3, Q4 columns:
/*---------+------+----+------+------+------+
 | product | year | Q1 | Q2   | Q3   | Q4   |
 +---------+------+----+------+------+------+
 | Apple   | 2025 | 77 | 0    | NULL | NULL |
 | Apple   | 2025 | 1  | NULL | NULL | NULL |
 | Nadi    | 2025 | 51 | 23   | 45   | 3    |
 | Madi    | 2025 | 70 | 85   | NULL | NULL |
 +---------+------+----+------+------+------*/