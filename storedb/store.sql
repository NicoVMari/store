-- Customer Table
CREATE TABLE Customer_t (
    id_customer NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    address VARCHAR2(255),
    email VARCHAR2(100)
);

-- Sequence for id_customer
CREATE SEQUENCE customer_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Trigger for auto-incrementing id_customer
CREATE OR REPLACE TRIGGER trg_customer_id
BEFORE INSERT ON Customer_t
FOR EACH ROW
BEGIN
    SELECT customer_seq.NEXTVAL
    INTO :new.id_customer
    FROM dual;
END;
/

-- Supplier Table
CREATE TABLE Supplier_t (
    id_supplier NUMBER PRIMARY KEY,
    supplier_name VARCHAR2(100) NOT NULL,
    contacts VARCHAR2(255)
);

-- Sequence for id_supplier
CREATE SEQUENCE supplier_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Trigger for auto-incrementing id_supplier
CREATE OR REPLACE TRIGGER trg_supplier_id
BEFORE INSERT ON Supplier_t
FOR EACH ROW
BEGIN
    SELECT supplier_seq.NEXTVAL
    INTO :new.id_supplier
    FROM dual;
END;
/

-- Product Table
CREATE TABLE Product_t (
    id_product NUMBER PRIMARY KEY,
    product_name VARCHAR2(100) NOT NULL,
    price NUMBER(10, 2),
    id_supplier NUMBER, 
    FOREIGN KEY (id_supplier) REFERENCES Supplier_t(id_supplier)
);

-- Sequence for id_product
CREATE SEQUENCE product_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Trigger for auto-incrementing id_product
CREATE OR REPLACE TRIGGER trg_product_id
BEFORE INSERT ON Product_t
FOR EACH ROW
BEGIN
    SELECT product_seq.NEXTVAL
    INTO :new.id_product
    FROM dual;
END;
/

-- Order Table
CREATE TABLE Order_t (
    id_order NUMBER PRIMARY KEY,
    id_customer NUMBER, 
    order_date DATE,
    total NUMBER(10, 2),
    FOREIGN KEY (id_customer) REFERENCES Customer_t(id_customer)
);

-- Sequence for id_order
CREATE SEQUENCE order_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Trigger for auto-incrementing id_order
CREATE OR REPLACE TRIGGER trg_order_id
BEFORE INSERT ON Order_t
FOR EACH ROW
BEGIN
    SELECT order_seq.NEXTVAL
    INTO :new.id_order
    FROM dual;
END;
/

-- Many-to-Many Relationship Table between Orders and Products
CREATE TABLE Orders_t (
    id_order NUMBER,  
    id_product NUMBER, 
    quantity INTEGER,  
    unit_price NUMBER(10, 2),
    PRIMARY KEY (id_order, id_product),
    FOREIGN KEY (id_order) REFERENCES Order_t(id_order),
    FOREIGN KEY (id_product) REFERENCES Product_t(id_product)
);

-- Holidays Table
CREATE TABLE Holiday_t (
    id_holiday NUMBER PRIMARY KEY,
    holiday_name VARCHAR2(100) NOT NULL,
    holiday_date DATE NOT NULL,
    description VARCHAR2(255)
);

-- Sequence for id_holiday
CREATE SEQUENCE holiday_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Trigger for auto-incrementing id_holiday
CREATE OR REPLACE TRIGGER trg_holiday_id
BEFORE INSERT ON Holiday_t
FOR EACH ROW
BEGIN
    SELECT holiday_seq.NEXTVAL
    INTO :new.id_holiday
    FROM dual;
END;
/

INSERT INTO Customer_t (name, address, email) VALUES ('Mario Rossi', 'Via Roma 1, Milano', 'mario.rossi@example.com');
INSERT INTO Customer_t (name, address, email) VALUES ('Luca Bianchi', 'Via Napoli 23, Roma', 'luca.bianchi@example.com');
INSERT INTO Customer_t (name, address, email) VALUES ('Giulia Verdi', 'Corso Torino 15, Torino', 'giulia.verdi@example.com');

INSERT INTO Supplier_t (supplier_name, contacts) VALUES ('Supplier A', 'info@suppliera.com');
INSERT INTO Supplier_t (supplier_name, contacts) VALUES ('Supplier B', 'contact@supplierb.com');
INSERT INTO Supplier_t (supplier_name, contacts) VALUES ('Supplier C', 'sales@supplierc.com');

INSERT INTO Product_t (product_name, price, id_supplier) VALUES ('Product 1', 19.99, 1);
INSERT INTO Product_t (product_name, price, id_supplier) VALUES ('Product 2', 29.99, 2);
INSERT INTO Product_t (product_name, price, id_supplier) VALUES ('Product 3', 39.99, 3);

INSERT INTO Order_t (id_customer, order_date, total) VALUES (1, TO_DATE('2025-03-21', 'YYYY-MM-DD'), 59.97);
INSERT INTO Order_t (id_customer, order_date, total) VALUES (2, TO_DATE('2025-03-22', 'YYYY-MM-DD'), 89.97);
INSERT INTO Order_t (id_customer, order_date, total) VALUES (3, TO_DATE('2025-03-23', 'YYYY-MM-DD'), 119.97);

INSERT INTO Orders_t (id_order, id_product, quantity, unit_price) VALUES (1, 1, 3, 19.99);
INSERT INTO Orders_t (id_order, id_product, quantity, unit_price) VALUES (1, 2, 2, 29.99);
INSERT INTO Orders_t (id_order, id_product, quantity, unit_price) VALUES (2, 2, 3, 29.99);
INSERT INTO Orders_t (id_order, id_product, quantity, unit_price) VALUES (2, 3, 1, 39.99);
INSERT INTO Orders_t (id_order, id_product, quantity, unit_price) VALUES (3, 1, 2, 19.99);
INSERT INTO Orders_t (id_order, id_product, quantity, unit_price) VALUES (3, 3, 1, 39.99);

INSERT INTO Holiday_t (holiday_name, holiday_date, description) VALUES ('New Year', TO_DATE('2025-01-01', 'YYYY-MM-DD'), 'New Year Holiday');
INSERT INTO Holiday_t (holiday_name, holiday_date, description) VALUES ('Easter', TO_DATE('2025-04-05', 'YYYY-MM-DD'), 'Easter Sunday');
INSERT INTO Holiday_t (holiday_name, holiday_date, description) VALUES ('Labor Day', TO_DATE('2025-05-01', 'YYYY-MM-DD'), 'International Labor Day');
INSERT INTO Holiday_t (holiday_name, holiday_date, description) VALUES ('Christmas', TO_DATE('2025-12-25', 'YYYY-MM-DD'), 'Christmas Day');
INSERT INTO Holiday_t (holiday_name, holiday_date, description) VALUES ('Independence Day', TO_DATE('2025-07-04', 'YYYY-MM-DD'), 'US Independence Day');

-- View per visualizzare gli ordini di un cliente con i dettagli dei prodotti
CREATE OR REPLACE VIEW v_customer_orders AS
SELECT
    c.id_customer,
    c.name AS customer_name,
    o.id_order,
    o.order_date,
    p.product_name,
    od.quantity,
    od.unit_price,
    (od.quantity * od.unit_price) AS total_product_price,
    o.total AS total_order_price
FROM
    Customer_t c
JOIN Order_t o ON c.id_customer = o.id_customer
JOIN Orders_t od ON o.id_order = od.id_order
JOIN Product_t p ON od.id_product = p.id_product;

SELECT * FROM v_customer_orders WHERE customer_name = 'Mario Rossi';


