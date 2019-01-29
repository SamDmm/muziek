insert into tracks(albumid, naam, tijd) values((select id from albums where naam='test'), 'test', 1);
insert into tracks(albumid, naam, tijd) values((select id from albums where naam='test'), 'test2', 10);
