create user teller password 'password';

grant alter any schema to teller;

create schema 'bank' authorization sa;