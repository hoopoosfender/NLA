INSERT INTO BOOK (author, title, ISBN) VALUES
('Aliko Dangote', 'Billionaire Industrialist', 'ISBN0001'),
('Bill Gates', 'Billionaire Tech Entrepreneur','ISBN1001'),
('Tom Hanks', 'Starcraft','ISBN2001'),
('James Brown', 'Funky!','ISBN3001'),
('Alex Peter', 'Summer Time','ISBN4001');

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

INSERT INTO PEOPLE_BOOK (people_id, books_id) VALUES
(2,2);
INSERT INTO PEOPLE_BOOK (people_id, books_id) VALUES
(2,3);