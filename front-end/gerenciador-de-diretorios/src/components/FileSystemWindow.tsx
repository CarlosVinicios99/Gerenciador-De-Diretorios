import File from '../models/File';
import Directory from '../models/Directory';
import './FileSystemWindow.css'
import DirectoryContainer from './DirectoryContainer';
import FileContainer from './FileContainer'
import { useEffect, useState } from 'react';
import DirectoriesService from '../services/directories.service';
import FilesService from '../services/files.service';
import Menu from './Menu';


const FileSystemWindow = () => {

    const [files, setFiles] = useState<File[]>([])

    const [directories, setDirectories] = useState<Directory[]>([])

    const [selectedDirectory, setSelectedDirectory] = useState<Directory>()

    const directoriesService: DirectoriesService = new DirectoriesService();
    const filesService: FilesService = new FilesService();

    const returnToThePreviousDirectory = async () => {
        if(selectedDirectory?.superDirectoryId){
            const directory: Directory = await directoriesService.findDirectoryById(selectedDirectory.superDirectoryId)
            if(directory){
                setSelectedDirectory(directory)
            }
        }
    }

    useEffect(() => {
        const findRootDirectory = async() => {
            const rootDirectory: Directory = await directoriesService.findRootDirectory()
            setSelectedDirectory(rootDirectory)
        }
        findRootDirectory()
    }, [])
    
    useEffect(() => {
        const findSubdirectoriesByDirectory = async(): Promise<void> => {

            if(!selectedDirectory){
                return
            }

            const subdirectories: Directory[] = 
                await directoriesService.findSubdirectoriesByDirectory(selectedDirectory.directoryId)
            setDirectories(subdirectories)

            const files: File[] = await filesService.findFilesByDirectoryId(selectedDirectory.directoryId)
            setFiles(files)
        }
        findSubdirectoriesByDirectory()
    }, [selectedDirectory])
    

    return (
        <div className="file-system-window-container">
            <Menu onChangeDirectory={() => returnToThePreviousDirectory()}/>
            {    
                directories.map(directory => (
                    <DirectoryContainer 
                        key={directory.directoryId} 
                        directory={directory}
                        onSelect={() => setSelectedDirectory(directory)}
                    />
                ))
            }
            {
                files.map(file => (
                    <FileContainer key={file.fileId} file={file}/>
                ))
                
            }
        </div>
    )

}
export default FileSystemWindow;