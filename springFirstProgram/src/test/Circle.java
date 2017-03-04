package test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*@Service // Implies it is a service
@Repository // Implies it is a data object
@Controller	// Implies it is a controller class when we use spring MVC framework
*/
@Component
//Used by spring to Converts class to spring bean 
public class Circle implements Shape,ApplicationEventPublisherAware //For Event Publisher
{
	
	@Autowired
	private MessageSource messageSource;	
	private Point center;
	//For Event Publisher
	private ApplicationEventPublisher publisher;
	public Point getCenter() {
		return center;
	}
	
	/*@Required
	@Autowired
	@Qualifier*/
	@Resource(name="point2")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@PostConstruct
	public void initmethod(){
		System.out.println("Initialization.... ");
	}
	
	@PreDestroy
	public void destroyMethod(){
		System.out.println("Destroy.... ");
	}
	
	public void draw(){
		System.out.println(this.messageSource.getMessage("drawing.circle",null,"Default Circle Message",null));
		System.out.println(this.messageSource.getMessage("drawing.point",new Object[]{center.getX(),center.getY()},"Default Point Message",null));
		//Creating a event and publishing it
		DrawEvent drawEvent=new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher=publisher;
	}
}
