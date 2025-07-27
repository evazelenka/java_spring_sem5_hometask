create table task (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(2000) NOT NULL,
    status VARCHAR(50) NOT NULL,
    date_of_create VARCHAR(50)
);