DROP TABLE IF EXISTS BOOK;

CREATE TABLE BOOK (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  author VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  ISBN VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS PEOPLE;

CREATE TABLE PEOPLE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  phone VARCHAR(250) DEFAULT NULL
);


DROP TABLE IF EXISTS PEOPLE_BOOK;

CREATE TABLE PEOPLE_BOOK (
  people_id INT NOT NULL,
  books_id INT NOT NULL,
  FOREIGN KEY (people_id) REFERENCES PEOPLE(id),
  FOREIGN KEY (books_id) REFERENCES BOOK(id),
);


INSERT INTO BOOK (author, title, ISBN) VALUES
('Aliko Dangote', 'Billionaire Industrialist', 'ISBN0001'),
('Bill Gates', 'Billionaire Tech Entrepreneur','ISBN1001'),
('Folrunsho Alakija', 'Billionaire Oil Magnate','ISBN2001');

INSERT INTO PEOPLE (name, email, phone) VALUES
('Aliko Dangote', 'a@gmail.com', '0423666'),
('Bill Gates', 'b@gmail.com','0422233'),
('Folrunsho Alakija', 'c@gmail.com','02444232');

INSERT INTO PEOPLE_BOOK (people_id, books_id) VALUES
(1,1);
INSERT INTO PEOPLE_BOOK (people_id, books_id) VALUES
(1,2);
INSERT INTO PEOPLE_BOOK (people_id, books_id) VALUES
(1,3);