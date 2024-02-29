-- Create tables for Item, Files, Permission groups, and Permissions
CREATE TABLE IF NOT EXISTS item (
    id SERIAL PRIMARY KEY,
    type VARCHAR(20) NOT NULL, -- 'Space', 'Folder', 'File'
    name VARCHAR(255) NOT NULL,
    permission_group_id INT,
    CONSTRAINT fk_permission_group_id FOREIGN KEY (permission_group_id) REFERENCES permission_groups(id)
);

CREATE TABLE IF NOT EXISTS files (
    id SERIAL PRIMARY KEY,
    binary BYTEA NOT NULL,
    item_id INT NOT NULL,
    CONSTRAINT fk_item_id FOREIGN KEY (item_id) REFERENCES item(id)
);

CREATE TABLE IF NOT EXISTS permission_groups (
    id SERIAL PRIMARY KEY,
    group_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS permissions (
    id SERIAL PRIMARY KEY,
    user_email VARCHAR(255) NOT NULL,
    permission_level VARCHAR(20) NOT NULL,
    group_id INT NOT NULL,
    CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES permission_groups(id)
);

