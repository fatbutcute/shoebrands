CREATE TABLE brand (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255)
);

CREATE TABLE shoe (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      model VARCHAR(255),
                      brand_id INT,
                      CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brand(id)
)