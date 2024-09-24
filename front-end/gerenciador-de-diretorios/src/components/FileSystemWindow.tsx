import File from '../models/File';
import Directory from '../models/Directory';
import './FileSystemWindow.css'
import DirectoryContainer from './DirectoryContainer';

interface FileSystemWindowProps {
    files: File[]
    directories: Directory[]
  }

const FileSystemWindow = ({
    files, 
    directories
}: FileSystemWindowProps) => {

  return (
    <div className="file-system-window-container">
        <DirectoryContainer key={1} directory={{name: "Vídeos", directoryId: "1"}}/>
        <DirectoryContainer key={2} directory={{name: "Documentos", directoryId: "2"}}/>
        <DirectoryContainer key={3} directory={{name: "Imagens", directoryId: "3"}}/>
    </div>
  )

}
export default FileSystemWindow;