-- Create Users table
CREATE TABLE Users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(100) NOT NULL
);

-- Create Categories table
CREATE TABLE Categories (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            category_name VARCHAR(50) NOT NULL
);

-- Create Expenses table
CREATE TABLE Expenses (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id INT,
                          category_id INT,
                          date DATE NOT NULL,
                          amount DECIMAL(10, 2) NOT NULL,
                          description TEXT,
                          FOREIGN KEY (user_id) REFERENCES Users(id),
                          FOREIGN KEY (category_id) REFERENCES Categories(id)
);
