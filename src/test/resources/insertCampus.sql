insert into campussen (naam, straat, huisnr, postcode, gemeente) values ('test', 'test', 'test', 'test', 'test');
insert into campussentelefoonnrs(campusid, nummer, fax, opmerking) values ((select id from campussen where naam = 'test'), '1', false, 'test');
