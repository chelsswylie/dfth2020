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
    step_code VARCHAR(50),
    title VARCHAR(50),
    description TEXT,
    status VARCHAR(20),
    step_order INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (order_item_id) REFERENCES order_item(id)
);

CREATE TABLE IF NOT EXISTS media (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    production_step_id UUID NOT NULL,
    media_url VARCHAR(2500) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (production_step_id) REFERENCES production_step(id)
);