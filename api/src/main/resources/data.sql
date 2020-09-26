DELETE FROM production_step WHERE id = 'a3eb1cf9-1dad-461f-8146-24792d677350';
DELETE FROM order_item WHERE id = '41b73992-3eac-4583-b11e-1a8b1fcad370';
DELETE FROM customer_order WHERE id = 'ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675';

INSERT INTO customer_order(id) VALUES ('ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675');

INSERT INTO order_item(id, order_id) VALUES ('41b73992-3eac-4583-b11e-1a8b1fcad370', 'ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675');

INSERT INTO production_step(id, order_item_id,step_code, title, description, status, step_order)
 VALUES ('a3eb1cf9-1dad-461f-8146-24792d677350', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'mmc', 'Marker Making & Cutting',
 'Marker Making & Cutting', 'not_started', 1);