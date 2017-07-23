package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.NoticeMapper;

import org.springframework.stereotype.Service;

import service.NoticeService;
import entity.Notice;
@Service
public class NoticeServiceImpl implements NoticeService {
	private NoticeMapper noticeMapper;
	@Resource(name="noticeMapper")
	public void setNoticeMapper(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	public List findAllNotice() {
		// TODO 自动生成的方法存根
		return noticeMapper.findAllNotice();
	}

	public Notice findById(String noticeId) {
		// TODO 自动生成的方法存根
		return noticeMapper.findById(noticeId);
	}

	public int save(Notice notice) {
		// TODO 自动生成的方法存根
		return noticeMapper.save(notice);
	}

	public int delete(String noticeId) {
		// TODO 自动生成的方法存根
		return noticeMapper.delete(noticeId);
	}

	public int update(Notice notice) {
		// TODO 自动生成的方法存根
		return noticeMapper.update(notice);
	}

	public List findAllNoticeType() {
		// TODO Auto-generated method stub
		return noticeMapper.findAllNoticeType();
	}

}
