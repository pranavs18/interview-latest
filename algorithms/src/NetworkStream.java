import java.util.ArrayList;

// given a network stream which sends data in a particular format
// h p h p h p
// Each header (h) is of a byte array of 4 bytes while payload is of size indicated by the interger value in the header byte array
// Any number of bytes can arrive in a single call to the readBytes() function.
// Once a payload is processed, you have to print the payload to the standard output
public class NetworkStream {

    ArrayList<byte[]> buffer;
    int payloadSize =0;

    boolean readHeader;

    public NetworkStream(){
        readHeader = true;
    }

    public void readBytes(byte []chunk) {
        if(chunk == null || chunk.length == 0) {
            return;
        }

        buffer.add(chunk);

        while(readBuffer(buffer));
    }

    private boolean readBuffer(ArrayList<byte[]> temp) {
        if (readHeader) {
            if (temp.size() > 4) {
                extractHeader(temp);
                return true;
            }
        } else {
            if (temp.size() > payloadSize) {
                extractPayload(temp);
                return true;
            }
        }
        return false;
    }

    private void extractHeader(ArrayList<byte[]> temp) {


        // read 4 elements from temp to get the size and update temp

        payloadSize = 8;    // extract payload size from the header
        readHeader = false;

    }

    private void extractPayload(ArrayList<byte[]> temp) {

        // read payloadSize elements from temp to  and update temp

        readHeader = true;
    }
}

class NetworkStreamCaller {

    public static void main(String args[]) {
        NetworkStream ns = new NetworkStream();
        ns.readBytes(new byte[]{0,1,2,3});

    }


}