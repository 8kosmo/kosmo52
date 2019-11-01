package com.network1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TalkServerThread extends Thread {
	TalkServer ts = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String nickName = null;//사용자의 닉네임 담김
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(ts.client.getOutputStream());
			ois = new ObjectInputStream(ts.client.getInputStream());
			String msg = (String)ois.readObject();
			ts.jta_log.append(msg+"\n");
			//자동으로 스크롤바 이동시켜주기
			ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
			StringTokenizer st = null;
			if(msg!=null) {
				st = new StringTokenizer(msg,Protocol.seperator);
			}
			st.nextToken();//100
			nickName = st.nextToken();//닉네임담기
			//나 이전에 들어와 있는 친구들에게 메시지 전송하기
			for(TalkServerThread tst:ts.chatList) {
				String currentName = tst.nickName;
				this.send(Protocol.ROOM_IN+Protocol.seperator+currentName);
			}
			//입장한 내 스레드 추가하기
			ts.chatList.add(this);
			//현재 서버에 접속해 있는 모든 사람들에게 메시지 전송하기
			this.broadCasting(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//서버에 접속한 모든 사용자들에게 메시지를 전송 처리함.
	public void broadCasting(String msg) {//200|누가|누구에게|오늘 스터디할까?
		//ts.jta_log.append("broadCasting:"+msg);
		for(TalkServerThread tst:ts.chatList) {
			tst.send(msg);//this.send(msg), tst.send(msg) 차이
		}
	}
	public void send(String msg) {//반복문은 필요없다.
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//run메소드 안에서는 무엇을 구현해야 되는걸까?
	public void run() {
		boolean isStop = false;
		try {
			run_start://break run_start;
			while(!isStop) {
				String msg = (String)ois.readObject();
				ts.jta_log.append(msg+"\n");//200|나신입|주말에 뭐해?
				ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
				int protocol = 0;
				StringTokenizer st = null;
				if(msg!=null) {
					st = new StringTokenizer(msg,"|");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch(protocol) {
				case Protocol.MESSAGE:{
					String nickName = st.nextToken();
					String message = st.nextToken();
					String imgChoice = st.nextToken();
					String fontColor = st.nextToken();
					/*
					 * JOptionPane.showMessageDialog(ts, Protocol.MESSAGE +
					 * Protocol.seperator+nickName + Protocol.seperator+message +
					 * Protocol.seperator+imgChoice+ Protocol.seperator+fontColor );
					 */
					 
					this.broadCasting(Protocol.MESSAGE
							        + Protocol.seperator+nickName
							        + Protocol.seperator+message
							        + Protocol.seperator+imgChoice
							        + Protocol.seperator+fontColor
							        );
					
				}break;
				case Protocol.WHISHER:{
					String nickName = st.nextToken();
					String otherName = st.nextToken();
					String msg1 = st.nextToken();
					for(TalkServerThread tst:ts.chatList) {
						if(otherName.equals(tst.nickName)) {//상대에게 보내는것.
							tst.send(Protocol.WHISHER+Protocol.seperator+nickName+Protocol.seperator+otherName+Protocol.seperator+msg1);
							break;
						}
					}
					//내가 한말을 내게 보내는것.
					this.send(Protocol.WHISHER
							 +Protocol.seperator+nickName
							 +Protocol.seperator+otherName
							 +Protocol.seperator+msg1);
				}break;	
				case Protocol.CHANGE:{
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					String msg1 = st.nextToken();
					this.nickName = afterName;//초기화
					broadCasting(Protocol.CHANGE
							 +Protocol.seperator+nickName
							 +Protocol.seperator+afterName
							 +Protocol.seperator+msg1);
				}break;
				case Protocol.ROOM_OUT:{//500|나신입
					String nickName = st.nextToken();
					String msg1 = nickName+"님이 퇴장하였습니다.";
					this.broadCasting(Protocol.ROOM_OUT
							        + Protocol.seperator+nickName
							        + Protocol.seperator+msg1
							         );
				}break run_start;
				}///////////end of switch
			}///////////////end of while
			System.out.println("여기");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}













