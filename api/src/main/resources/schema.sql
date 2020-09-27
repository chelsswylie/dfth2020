CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS customer_order (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS order_item (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    order_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES customer_order(id)
);

CREATE TABLE IF NOT EXISTS production_step (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    order_item_id UUID NOT NULL,
    step_code VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL,
    step_order INTEGER NOT NULL,
    media_url VARCHAR(2500),
    PRIMARY KEY (id),
    FOREIGN KEY (order_item_id) REFERENCES order_item(id)
);
