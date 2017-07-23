package mapper;

import java.util.List;

import entity.Menu;
import entity.Notice;

public interface NoticeMapper {
	List findAllNotice();
	List findAllNoticeType();
	Notice findById(String noticeId);
	public int save(Notice notice);
	public int delete(String noticeId);
	public int update(Notice notice);
}
