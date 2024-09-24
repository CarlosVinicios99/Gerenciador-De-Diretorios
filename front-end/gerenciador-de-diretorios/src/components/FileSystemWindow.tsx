import File from '../models/File';
import Directory from '../models/Directory';
import './FileSystemWindow.css'
import DirectoryContainer from './DirectoryContainer';
import FileContainer from './FileContainer'
import { useEffect, useState } from 'react';
import DirectoriesService from '../services/directories.service';
import FilesService from '../services/files.service';


const FileSystemWindow = () => {

    const [files, setFiles] = useState<File[]>([])

    const [directories, setDirectories] = useState<Directory[]>([])

    const [selectedDirectory, setSelectedDirectory] = useState<Directory>()

    const directoriesService: DirectoriesService = new DirectoriesService();
    const filesService: FilesService = new FilesService();

    useEffect(() => {
        const findRootDirectory = async() => {
            const rootDirectory: Directory = await directoriesService.findRootDirectory()
            setSelectedDirectory(rootDirectory)
        }
        findRootDirectory()
    }, [])
    
    useEffect(() => {
        const findSubdirectoriesByDirectory = async() => {

            if(!selectedDirectory){
                return
            }

            const subdirectories: Directory[] = 
                await directoriesService.findSubdirectoriesByDirectory(selectedDirectory?.directoryId || "")
            setDirectories(subdirectories)

            const files: File[] = await filesService.findFilesByDirectoryId(selectedDirectory?.directoryId || "")
            setFiles(files)
        }
        findSubdirectoriesByDirectory()
    }, [selectedDirectory])
    

    return (
        <div className="file-system-window-container">
            <div className="menu-container">
                <button className="back-button">Voltar ao diretório anterior</button>
                <div className="options-add-container">
                    <button className="add-file-button">
                        <img 
                            src="./../../public/images/icone-adicionar-arquivo.png" 
                            alt="ícone de adicionar arquivo" 
                            className="add-file-icon"
                        />
                    </button>
                    <button className="add-folder-button">
                        <img 
                            src="./../../public/images/icone-adicionar-pasta.png" 
                            alt="ícone de adicionar pasta"
                            className="add-folder-icon"
                        />
                    </button>
                </div>
            </div>
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