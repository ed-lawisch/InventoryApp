-- Inserting categories
INSERT INTO category (name) VALUES ('Hand Tools');
INSERT INTO category (name) VALUES ('Power Tools');
INSERT INTO category (name) VALUES ('Fasteners');
INSERT INTO category (name) VALUES ('Building Materials');

-- Inserting products for Hand Tools (Category ID: 1)
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Hammer', 'Sturdy hammer', 15.50, 'Hand Tools', true, 1);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Screwdriver Set', 'Set of 5 screwdrivers', 10.00, 'Hand Tools', true, 1);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Wrench', 'Adjustable wrench', 12.00, 'Hand Tools', true, 1);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Pliers', 'Heavy-duty pliers', 9.00, 'Hand Tools', true, 1);

-- Inserting products for Power Tools (Category ID: 2)
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Drill', 'Cordless drill', 80.00, 'Power Tools', true, 2);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Circular Saw', 'High-precision saw', 130.00, 'Power Tools', true, 2);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Jigsaw', 'Versatile jigsaw', 70.00, 'Power Tools', true, 2);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Angle Grinder', 'Compact grinder', 60.00, 'Power Tools', true, 2);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Heat Gun', 'Variable heat gun', 40.00, 'Power Tools', true, 2);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Impact Driver', 'Impact driver', 90.00, 'Power Tools', true, 2);

-- Inserting products for Fasteners (Category ID: 3)
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Nails Pack', '1000 nails', 6.00, 'Fasteners', true, 3);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Screws Pack', '500 screws', 8.00, 'Fasteners', true, 3);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Bolts Pack', '200 bolts', 6.50, 'Fasteners', true, 3);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Nuts Pack', '300 nuts', 4.50, 'Fasteners', true, 3);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Washers Pack', '400 washers', 4.00, 'Fasteners', true, 3);

-- Inserting products for Building Materials (Category ID: 4)
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Cement', '50kg bag of cement', 11.00, 'Building Materials', true, 4);
INSERT INTO product (name, description, price, category_path, available, category_id)
VALUES ('Bricks', '50 bricks', 26.00, 'Building Materials', true, 4);
