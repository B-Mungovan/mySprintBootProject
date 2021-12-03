DROP TABLE IF EXISTS poke CASCADE;
CREATE TABLE poke(
id integer auto_increment,
poke_level integer not null, 
poke_name varchar(255), 
poke_nature varchar(255), 
poke_type varchar(255), 
primary key (id))