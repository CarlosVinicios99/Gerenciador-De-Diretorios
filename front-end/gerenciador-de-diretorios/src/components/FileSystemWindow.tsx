import File from '../models/File';
import Directory from '../models/Directory';
import './FileSystemWindow.css'

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
        
    </div>
  )

}
export default FileSystemWindow;