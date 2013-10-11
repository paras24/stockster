package com.impetus.ee.common;

import java.util.Date;

import javax.persistence.EntityListeners;

import org.hibernate.event.PreInsertEvent;
import org.hibernate.event.PreInsertEventListener;
import org.hibernate.event.PreUpdateEvent;
import org.hibernate.event.PreUpdateEventListener;

import com.impetus.ee.domain.DomainObject;

@EntityListeners(value={DomainObject.class})
public class TracebilityListener implements PreInsertEventListener,PreUpdateEventListener 
{
    private void setPropertyState(Object[] propertyStates, String[] propertyNames,String propertyName,Object propertyState) {
        for(int i=0;i<propertyNames.length;i++) {
            if (propertyName.equals(propertyNames[i])) {
                propertyStates[i]=propertyState;
                return;
            }
        }
    }
    private void onInsert(Object entity,Object[] state, String[] propertyNames) {
    	
    	
        if (entity instanceof DomainObject) 
        {
        	DomainObject domainObject = (DomainObject) entity;
            Date date=new Date();
            domainObject.setCreated(date);
            setPropertyState(state, propertyNames, "created", date);
            domainObject.setModified(date);
            setPropertyState(state, propertyNames, "modified", date);
        }
    }

    private void onUpdate(Object entity,Object[] state, String[] propertyNames) {
    	if (entity instanceof DomainObject) 
        {
        	DomainObject domainObject = (DomainObject) entity;
            Date date=new Date();
            setPropertyState(state, propertyNames, "created", domainObject.getCreated());
            domainObject.setModified(date);
            setPropertyState(state, propertyNames, "modified", date);
        }
    }

    
    public boolean onPreInsert(PreInsertEvent event) 
    {
    	onInsert(event.getEntity(), event.getState(), event.getPersister().getPropertyNames());
        return false;
    }

    
    public boolean onPreUpdate(PreUpdateEvent event) {
        onUpdate(event.getEntity(), event.getState(), event.getPersister().getPropertyNames());
        return false;
    }
}
