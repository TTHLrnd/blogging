DROP DATABASE IF EXISTS blogDatabase;
CREATE DATABASE IF NOT EXISTS blogDatabase;
USE blogDatabase;

CREATE TABLE IF NOT EXISTS authors(
	id INT AUTO_INCREMENT,
    username VARCHAR(75) NOT NULL,
    email VARCHAR(75) NOT NULL,
    password VARCHAR(75) NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    role ENUM ("user", "mod", "admin"),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS blogs(
	id INT AUTO_INCREMENT,
    title VARCHAR(75) NOT NULL,
    content TEXT NOT NULL,
    authorid INT NOT NULL,
    pubdate TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (authorid) REFERENCES authors (id)
);

CREATE TABLE IF NOT EXISTS comments(
	id INT AUTO_INCREMENT,
    pubdate TIMESTAMP DEFAULT NOW(),
    blogid INT NOT NULL,
    authorid INT NOT NULL,
    comment TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (blogid) REFERENCES blogs(id),
    FOREIGN KEY (authorid) REFERENCES authors(id)
    
);