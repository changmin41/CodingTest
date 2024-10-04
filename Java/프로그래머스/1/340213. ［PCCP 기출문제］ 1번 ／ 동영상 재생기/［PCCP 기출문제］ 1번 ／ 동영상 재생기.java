class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
 //video_len: 동영상 길이, pos: 현재 동영상 위치, [op_start,op_end]: 오프닝 시작과 끝,
        // commands: 특정 명령어들이 들어있는 배열
        String answer = "";

        int total_len = 0;
        int iPos = 0, iOpStart = 0, iOpEnd; // 현재 재생위치, 특정 구간의 시작, 특정 구간의 끝

        // 총 동영상 길이
        total_len = Integer.parseInt(video_len.split(":")[0]) *60 + //총 길이, 문자열 ":"로 나눠서 구분
             Integer.parseInt(video_len.split(":")[1]);

        //현재 동영상 위치
        iPos = Integer.parseInt(pos.split(":")[0]) *60
        + Integer.parseInt(pos.split(":")[1]);

        //특정 구간 시작
        iOpStart = Integer.parseInt(op_start.split(":")[0]) *60
                + Integer.parseInt(op_start.split(":")[1]);

        //특정 구간 끝
        iOpEnd = Integer.parseInt(op_end.split(":")[0]) *60
                + Integer.parseInt(op_end.split(":")[1]);

        // 처음 위치가 오프닝 구간에 있으면 오프닝 끝으로 이동
        if (iPos >= iOpStart && iPos <= iOpEnd) {
            iPos = iOpEnd;
        }


        //10초 전으로 돌리기
        for(int i = 0; i < commands.length; i++){
            if(commands[i].equals("prev")){
                iPos -= 10;
                if(iPos < 0){
                    iPos = 0;
                }
            }else if(commands[i].equals("next")){ //10초 빨리감기
                iPos += 10;
                if(total_len - iPos < 10){
                    iPos = total_len;
                }
            }
            if( iPos >= iOpStart && iPos <= iOpEnd){ //만약 오프닝이 스타트보다 크고 끝지점보다 작으면 끝지점으로 가라
                iPos = iOpEnd;
            }
        }
        answer = String.format("%02d:%02d", iPos/60, iPos%60);
        return answer;
    }
        }