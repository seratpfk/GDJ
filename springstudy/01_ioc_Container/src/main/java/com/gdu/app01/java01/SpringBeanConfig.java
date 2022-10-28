package com.gdu.app01.java01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 	@Configuration
 	�ȳ�. �� Bean�� ����� Java �����̾�.
 	Spring Bean Configuration File�ϰ� �ϴ� ���� ����.
 */

@Configuration
public class SpringBeanConfig {

	// �޼ҵ� �ϳ��� Bean �ϳ��� �þƼ� �����Ѵ�.
	
	/*
	 	@Bean
	 	�ȳ�. �� Bean�� ����� �޼ҵ��.
	 	�޼ҵ��̸��� Bean�� �̸�(id)�̰�,
	 	��ȯŸ���� Bean�� Ÿ��(class)��.
	 	
	 */
	
	/*
	 	<bean id="song1" class="Song">
	 		<property name="title" value="����1"/>
	 		<property name="genre" value="�帣1"/>
	 	</bean>
	 */
	
	@Bean
	public Song song1() {
		Song song = new Song();
		song.setTitle("����1");
		song.setGenre("�帣1");
		return song;
	}
	
	/*
 	<bean id="song2" class="Song">
 		<property name="title" value="����2"/>
 		<property name="genre" value="�帣2"/>
 	</bean>
	*/

	@Bean(name="song2")  // @Bean�� name���� �����ϸ� id�� ���ȴ�.
	public Song sadjksfd1() { // �޼ҵ��̸��� �ƹ��ų� ��� �ȴ�.
		Song song = new Song();
		song.setTitle("����2");
		song.setGenre("�帣2");
		return song;
	}
	
	/*
 	<bean id="song3" class="Song">
 		<property name="title" value="����3"/>
 		<property name="genre" value="�帣3"/>
 	</bean>
	*/
	@Bean
	public Song song3() {
		return new Song("����3", "�帣3");
	}
	
	// �̼�
	
	// song1�� ������ singer1�� ����� ����
	// setter injection
	
	@Bean
	public Singer singer1() {
		Singer singer = new Singer();
		singer.setName("����1");
		singer.setSong(song1());
		return singer;
	}
	
	
	// song2�� ������ singer2�� ����� ����
	// setter injection
	
	@Bean(name="singer2")
	public Singer qdse() {
		Singer singer = new Singer();
		singer.setName("����2");
		singer.setSong(sadjksfd1());
		return singer;
	}
	
	// song3�� ������ singer3�� ����� ����
	// setter injection
	
	@Bean
	public Singer singer3() {
		return new Singer("����3", song3());
	}
	
}
