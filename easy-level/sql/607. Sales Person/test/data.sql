INSERT INTO SalesPerson (sales_id, name, salary, commission_rate, hire_date) VALUES ('1', 'John', '100000', '6', PARSEDATETIME('4/1/2006', 'M/d/yyyy'));
INSERT INTO SalesPerson (sales_id, name, salary, commission_rate, hire_date) VALUES ('2', 'Amy', '12000', '5', PARSEDATETIME('5/1/2010', 'M/d/yyyy'));
INSERT INTO SalesPerson (sales_id, name, salary, commission_rate, hire_date) VALUES ('3', 'Mark', '65000', '12', PARSEDATETIME('12/25/2008', 'M/d/yyyy'));
INSERT INTO SalesPerson (sales_id, name, salary, commission_rate, hire_date) VALUES ('4', 'Pam', '25000', '25', PARSEDATETIME('1/1/2005', 'M/d/yyyy'));
INSERT INTO SalesPerson (sales_id, name, salary, commission_rate, hire_date) VALUES ('5', 'Alex', '5000', '10', PARSEDATETIME('2/3/2007', 'M/d/yyyy'));

INSERT INTO Company (com_id, name, city) VALUES ('1', 'RED', 'Boston');
INSERT INTO Company (com_id, name, city) VALUES ('2', 'ORANGE', 'New York');
INSERT INTO Company (com_id, name, city) VALUES ('3', 'YELLOW', 'Boston');
INSERT INTO Company (com_id, name, city) VALUES ('4', 'GREEN', 'Austin');

INSERT INTO Orders (order_id, order_date, com_id, sales_id, amount) VALUES ('1', PARSEDATETIME('1/1/2014', 'M/d/yyyy'), '3', '4', '10000');
INSERT INTO Orders (order_id, order_date, com_id, sales_id, amount) VALUES ('2', PARSEDATETIME('2/1/2014', 'M/d/yyyy'), '4', '5', '5000');
INSERT INTO Orders (order_id, order_date, com_id, sales_id, amount) VALUES ('3', PARSEDATETIME('3/1/2014', 'M/d/yyyy'), '1', '1', '50000');
INSERT INTO Orders (order_id, order_date, com_id, sales_id, amount) VALUES ('4', PARSEDATETIME('4/1/2014', 'M/d/yyyy'), '1', '4', '25000');