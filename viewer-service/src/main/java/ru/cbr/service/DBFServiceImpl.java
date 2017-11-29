package ru.cbr.service;

import org.apache.commons.lang3.StringUtils;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.utils.DbfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cbr.Constants;
import ru.cbr.model.*;
import ru.cbr.repository.*;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Objects;

@Service
public class DBFServiceImpl implements DBFService {

    private static final Logger log = LoggerFactory.getLogger(DBFServiceImpl.class);

    private static final String CHARSET = "cp866";

    @Value("${documents.dir}")
    private String documentDir;

    @Autowired
    private PZNRepository pznRepository;

    @Autowired
    private REALRepository realRepository;

    @Autowired
    private REGRepository regRepository;

    @Autowired
    private TNPRepository tnpRepository;

    @Autowired
    private UERRepository uerRepository;

    @Autowired
    private BNKSEEKRepository bnkseekRepository;

    @Override
    @Transactional
    public void fillDB() {

        fillPznDb();
        fillRealDb();
        fillRegDb();
        fillTnpDb();
        fillUerDb();

        fillBnkseekDb();

    }

    //fix framework bug
    private static Date validateDate(Date date) {
        if (date.getTime() < 0) {
            return null;
        }
        return date;
    }

    private void fillPznDb() {
        try (DbfReader reader = new DbfReader(new File(documentDir + Constants.PZN))) {
            Object[] row;
            while ((row = reader.nextRecord()) != null) {
                byte i = 0;
                String vkey = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String pzn = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String imy = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String name = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                Date cb_date = validateDate((Date) row[i++]);
                Date ce_date = validateDate((Date) row[i++]);
                i = 0;

                PZN entity = new PZN(vkey, pzn, imy, name, cb_date, ce_date);

                try {
                    if (Objects.isNull(pznRepository.findOneByVkey(vkey))) {
                        pznRepository.save(entity);
                    }
                } catch (Exception e) {
                    log.error("Error try to save entity PZN", e);
                    //already exist or something else
                }
            }
        }
    }

    private void fillRealDb() {
        try (DbfReader reader = new DbfReader(new File(documentDir + Constants.REAL))) {
            Object[] row;
            while ((row = reader.nextRecord()) != null) {
                byte i = 0;
                String vkey = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String real = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String nameOgr = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                i = 0;

                REAL entity = new REAL(vkey, real, nameOgr);

                try {
                    if (Objects.isNull(realRepository.findOneByVkey(vkey))) {
                        realRepository.save(entity);
                    }
                } catch (Exception e) {
                    log.error("Error try to save entity PZN", e);
                    //already exist or something else
                }
            }
        }
    }

    private void fillRegDb() {
        try (DbfReader reader = new DbfReader(new File(documentDir + Constants.REG))) {
            Object[] row;
            while ((row = reader.nextRecord()) != null) {
                byte i = 0;
                String vkey = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String rgn = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String name = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String center = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String namet = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                i = 0;

                REG entity = new REG(vkey, rgn, name, center, namet);

                try {
                    if (Objects.isNull(regRepository.findOneByVkey(vkey))) {
                        regRepository.save(entity);
                    }
                } catch (Exception e) {
                    log.error("Error try to save entity REG", e);
                    //already exist or something else
                }
            }
        }
    }

    private void fillTnpDb() {
        try (DbfReader reader = new DbfReader(new File(documentDir + Constants.TNP))) {
            Object[] row;
            while ((row = reader.nextRecord()) != null) {
                byte i = 0;
                String vkey = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String tnp = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String fullname = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String shortname = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                i = 0;

                TNP entity = new TNP(vkey, tnp, fullname, shortname);

                try {
                    if (Objects.isNull(tnpRepository.findOneByVkey(vkey))) {
                        tnpRepository.save(entity);
                    }
                } catch (Exception e) {
                    log.error("Error try to save entity TNP", e);
                    //already exist or something else
                }
            }
        }
    }

    private void fillUerDb() {
        try (DbfReader reader = new DbfReader(new File(documentDir + Constants.UER))) {
            Object[] row;
            while ((row = reader.nextRecord()) != null) {
                byte i = 0;
                String vkey = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String uer = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                String uername = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                i = 0;

                UER entity = new UER(vkey, uer, uername);

                try {
                    if (Objects.isNull(uerRepository.findOneByVkey(vkey))) {
                        uerRepository.save(entity);
                    }
                } catch (Exception e) {
                    log.error("Error try to save entity UER", e);
                    //already exist or something else
                }
            }
        }

    }

    private void fillBnkseekDb() {
        try (DbfReader reader = new DbfReader(new File(documentDir + Constants.BNKSEEK))) {
            Object[] row;
            while ((row = reader.nextRecord()) != null) {
                BNKSEEK bnkseek = new BNKSEEK();
                byte i = 0;
                String vkey = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setVkey(vkey);

                String real = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                if (StringUtils.isNotEmpty(real)) {
                    REAL entity = realRepository.findOneBy(real);
                    bnkseek.setReal(entity);
                }

                String pzn = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                if (StringUtils.isNotEmpty(pzn)) {
                    PZN entity = pznRepository.findOneBy(pzn);
                    bnkseek.setPzn(entity);
                }

                String uer = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                if (StringUtils.isNotEmpty(uer)) {
                    UER entity = uerRepository.findOneBy(uer);
                    bnkseek.setUer(entity);
                }

                String rgn = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                if (StringUtils.isNotEmpty(rgn)) {
                    REG entity = regRepository.findOneBy(rgn);
                    bnkseek.setRgn(entity);
                }

                String ind = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setInd(ind);

                String tnp = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                if (StringUtils.isNotEmpty(tnp)) {
                    TNP entity = tnpRepository.findOneBy(tnp);
                    bnkseek.setTnp(entity);
                }

                String nnp = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setNnp(nnp);

                String adr = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setAdr(adr);

                String rkc = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setRkc(rkc);

                String namep = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setNamep(namep);

                String namen = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setNamen(namen);

                String newnum = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setNewnum(newnum);

                String newks = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setNewks(newks);

                String permfo = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setPermfo(permfo);

                String srok = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setSrok(srok);

                String at1 = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setAt1(at1);

                String at2 = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setAt2(at2);

                String telef = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setTelef(telef);

                String regn = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setRegn(regn);

                String okpo = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setOkpo(okpo);

                Date dtIzm = validateDate((Date) row[i++]);
                bnkseek.setDtIzm(dtIzm);

                String cks = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setCks(cks);

                String ksnp = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                bnkseek.setKsnp(ksnp);

                Date dIn = validateDate((Date) row[i++]);
                bnkseek.setDateIn(dIn);

                Date dCh = validateDate((Date) row[i++]);
                bnkseek.setDateCh(dCh);

                String vkeyDel = new String(DbfUtils.trimLeftSpaces((byte[]) row[i++]), Charset.forName(CHARSET));
                if (StringUtils.isNotEmpty(vkeyDel)) {
                    BNKSEEK entity = bnkseekRepository.findOneBy(vkeyDel);
                    bnkseek.setVkeyDel(entity);
                }

                Date dtIzmr = validateDate((Date) row[i++]);
                bnkseek.setDtIzmr(dtIzmr);

                i = 0;


                try {
                    if (Objects.isNull(bnkseekRepository.findOneBy(vkey))) {
                        bnkseekRepository.save(bnkseek);
                    }
                } catch (Exception e) {
                    log.error("Error try t save entity BNKSEEK", e);
                    //already exist or something else
                }
            }
        }

    }
}
