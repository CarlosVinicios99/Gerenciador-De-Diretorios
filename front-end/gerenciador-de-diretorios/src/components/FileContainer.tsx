import React from 'react'
import File from '../models/File'
import './FileContainer.css'

interface FileProps {
  file: File
}

const FileContainer = ({file}: FileProps) => {
  return (
    <>
      <div className='file-container'>
        <img src="../../public/images/icone-de-arquivo.png" alt="ícone de arquivo" className='file-icon' />
        <span>{file.name}</span>
      </div>
      <hr className='separator-line'/>
    </>
  )
}
export default FileContainer