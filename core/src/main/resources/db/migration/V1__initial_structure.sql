use bootcamp;

create table user
(
    id          int primary key not null auto_increment,
    last_name   char(40),
    first_name  char(20),
    middle_name char(40),
    email       char(50),
    role        char(50)
);