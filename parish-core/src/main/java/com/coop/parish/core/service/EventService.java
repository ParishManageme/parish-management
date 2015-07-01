package com.coop.parish.core.service;

import java.util.List;

import com.coop.parish.core.beans.EventBean;
import com.coop.parish.core.beans.UserBean;

public interface EventService extends BaseService{
	
	public EventBean saveEvent(EventBean eventBean, UserBean user) throws Exception;
	
	public EventBean getEventById(int id) throws Exception;
	
	public EventBean updateEvent(EventBean eventBean, UserBean user) throws Exception;
	
	public int deleteEvent(Integer id) throws Exception;
	
	public List<EventBean> getAllEventsOfChurch(Integer churchId) throws Exception;
}
