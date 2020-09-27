DELETE FROM production_step WHERE id = '07ff4e60-75af-4e03-bbf9-07748a9814cb';
DELETE FROM production_step WHERE id = 'f18d76de-a296-4e8b-b820-ce58d89fde4f';
DELETE FROM production_step WHERE id = '3500711f-976e-4d6c-bf2e-20592107db50';
DELETE FROM production_step WHERE id = '9d150281-4005-45d0-b92d-40b5956e8544';
DELETE FROM production_step WHERE id = 'a59cb401-d8b4-4feb-871b-09f1abd168c1';
DELETE FROM production_step WHERE id = 'befec777-9896-452e-8dc9-ad38431563e1';
DELETE FROM production_step WHERE id = '06f46dfe-097b-4fe7-b8e1-5dee6f02ea98';
DELETE FROM production_step WHERE id = '0fae474b-8ce3-4d41-97d2-ceeb6fbdee2c';
DELETE FROM production_step WHERE id = 'a3eb1cf9-1dad-461f-8146-24792d677350';
DELETE FROM order_item WHERE id = '41b73992-3eac-4583-b11e-1a8b1fcad370';
DELETE FROM customer_order WHERE id = 'ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675';

INSERT INTO customer_order(id) VALUES ('ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675');

INSERT INTO order_item(id, order_id) VALUES ('41b73992-3eac-4583-b11e-1a8b1fcad370', 'ddfc229c-3c4f-4c5f-a59f-d7a1d8da8675');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('a3eb1cf9-1dad-461f-8146-24792d677350', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'mmc', 'Marker Making & Cutting',
'Marker Making & Cutting', 'not_started', 1, '/assets/steps/6.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('0fae474b-8ce3-4d41-97d2-ceeb6fbdee2c', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'prep', 'Prep',
'Prep', 'not_started', 2, '/assets/steps/7.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('06f46dfe-097b-4fe7-b8e1-5dee6f02ea98', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'fp', 'Front Panel',
 'Front Panel', 'not_started', 3, '/assets/steps/8.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('befec777-9896-452e-8dc9-ad38431563e1', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'bp', 'Back Panel',
 'Back Panel', 'not_started', 4, '/assets/steps/9.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('a59cb401-d8b4-4feb-871b-09f1abd168c1', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'm', 'Marriage',
 'Marriage', 'not_started', 5, '/assets/steps/10.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('9d150281-4005-45d0-b92d-40b5956e8544', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'waist', 'Waistband',
'Waistband', 'not_started', 6, '/assets/steps/11.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('3500711f-976e-4d6c-bf2e-20592107db50', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'finish', 'Finishing',
'Finishing', 'not_started', 7, '/assets/steps/dfth2020pic4.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('f18d76de-a296-4e8b-b820-ce58d89fde4f', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'qc', 'Quality Control',
'Quality Control', 'not_started', 8, '/assets/steps/pic5.png');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order, media_url)
VALUES ('07ff4e60-75af-4e03-bbf9-07748a9814cb', '41b73992-3eac-4583-b11e-1a8b1fcad370', 'ff', 'Fulfillment',
'Fulfillment', 'not_started', 9, NULL);

DELETE FROM production_step WHERE id = 'cf5753a0-f15d-41fc-86ff-209753af65f7';
DELETE FROM production_step WHERE id = '85892daa-d8a0-409f-9d69-15fe77351834';
DELETE FROM production_step WHERE id = '7f239ea8-c532-46af-9734-835d9a309a4d';
DELETE FROM production_step WHERE id = 'e5c38851-126e-44b3-bb28-729133efcb5d';
DELETE FROM production_step WHERE id = '0cf0e5e1-e4b4-4342-91cc-8b4a970c59bd';
DELETE FROM production_step WHERE id = 'a125d9e3-a919-4a28-ad3e-f6e8a2e5b479';
DELETE FROM production_step WHERE id = '0d8b9620-70a3-4bf6-a554-91d8fd16c3bc';
DELETE FROM production_step WHERE id = '86f4d2a4-68da-497e-aa35-b6fcfb55bec3';
DELETE FROM production_step WHERE id = '6ac3221e-5d30-4e2b-bb63-52a3020a7ada';
DELETE FROM order_item WHERE id = '9530e143-454d-427a-8f1d-7c58b15d9a41';
DELETE FROM customer_order WHERE id = '57d27ef3-2906-4a08-9518-4c52993144ad';

INSERT INTO customer_order(id) VALUES ('57d27ef3-2906-4a08-9518-4c52993144ad');

INSERT INTO order_item(id, order_id) VALUES ('9530e143-454d-427a-8f1d-7c58b15d9a41', '57d27ef3-2906-4a08-9518-4c52993144ad');

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('6ac3221e-5d30-4e2b-bb63-52a3020a7ada', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'mmc', 'Marker Making & Cutting',
'Marker Making & Cutting', 'not_started', 1);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('86f4d2a4-68da-497e-aa35-b6fcfb55bec3', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'prep', 'Prep',
'Prep', 'not_started', 2);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('0d8b9620-70a3-4bf6-a554-91d8fd16c3bc', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'fp', 'Front Panel',
'Front Panel', 'not_started', 3);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('a125d9e3-a919-4a28-ad3e-f6e8a2e5b479', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'bp', 'Back Panel',
'Back Panel', 'not_started', 4);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('0cf0e5e1-e4b4-4342-91cc-8b4a970c59bd', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'm', 'Marriage',
'Marriage', 'not_started', 5);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('e5c38851-126e-44b3-bb28-729133efcb5d', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'waist', 'Waistband',
'Waistband', 'not_started', 6);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('7f239ea8-c532-46af-9734-835d9a309a4d', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'finish', 'Finishing',
'Finishing', 'not_started', 7);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('85892daa-d8a0-409f-9d69-15fe77351834', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'qc', 'Quality Control',
'Quality Control', 'not_started', 8);

INSERT INTO production_step(id, order_item_id, step_code, title, description, status, step_order)
VALUES ('cf5753a0-f15d-41fc-86ff-209753af65f7', '9530e143-454d-427a-8f1d-7c58b15d9a41', 'ff', 'Fulfillment',
'Fulfillment', 'not_started', 9);
