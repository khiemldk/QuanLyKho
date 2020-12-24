package QuanLyKho.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import QuanLyKho.Entity.history;

@Repository
@Transactional(rollbackFor = Exception.class)
public class HistoryDAOImpliment extends BaseDAOImplement<history> implements HistoryDAO<history>{

}
